using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Media;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/*
 * the main idea comes from http://www.dreamincode.net/forums/topic/39686-creating-a-fully-functional-pong-game/
 * add some new features according to assignment #7's requirements
 * Convert Visual Basic .Net into c# in this assignment
 
 */
namespace PongC
{
    public partial class pongMain : Form
    {
        double speed = 10;//Ball Speed
        int compScore = 0;
        
        Random rndInst = new Random();//Random instance
        double xVel;
        double yVel;
        int plrScore = 0;
        RoundedPictureBox gameBall = new RoundedPictureBox();
        public pongMain()
        {
            InitializeComponent();
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.pongMain_MouseMove);
            this.KeyDown  += new System.Windows.Forms.KeyEventHandler (this.pongMain_KeyDown);
        }

        /*
         * Escape the game when escape has been pressed.
         * using application.exit method rather than me.close
         */

        private void pongMain_KeyDown(object sender, System.Windows.Forms.KeyEventArgs e) {
            if (e.KeyCode == Keys.Escape) {
                Application.Exit();
            }
        }

        //init the game when starting
        private void Form1_Load(object sender, EventArgs e)
        {
            //hide the cursor for more convenience control
            System.Windows.Forms.Cursor.Hide();
            xVel = Math.Cos(rndInst.Next(5, 10)) * speed;
            yVel = Math.Sin(rndInst.Next(5, 10)) * speed;
            //create a new ball object using the customed pictureBox
            gameBall.BackColor = Color.Red;
            Size size= new Size(20, 20);
            gameBall.Size = size;
            gameBall.Visible = true;
            //add this new control into current stacks of controls
            this.Controls.Add(gameBall);
        }

        //Move the paddle according to the mouse position.
        //according to the assignment #7, using mouse or keyboard is both accepted
        private void pongMain_MouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (e.Y > 5 && e.Y < this.Height - 40 - paddlePlayer.Height) {
                paddlePlayer.Location = new Point(paddlePlayer.Location.X, e.Y);
            }
        }

        //the main method for this game
        //the interval of timer has been set by 20ms, so each 20ms the code in this method will be run


        private void gameTimer_Tick(object sender, EventArgs e)
        {
            //the first step is to move the ball
            gameBall.Location = new Point((int)(gameBall.Location.X + xVel), (int)(gameBall.Location.Y + yVel));
            //Check for bottom wall, if the ball is out of windows, reset the location
            if (gameBall.Location.Y > this.Height - gameBall.Size.Height - 45)
            {
                gameBall.Location = new Point(gameBall.Location.X, this.Height - gameBall.Size.Height - 45);
                yVel = -yVel;
            }
            // Check for top wall, if the ball is out of windows, reset the location


            if (gameBall.Location.Y < 0)
            {
                gameBall.Location = new Point(gameBall.Location.X, 0);
                yVel = -yVel;
            }
            // Check for computer paddle, set the computer player' paddle in a correct position in order to hit the ball
        // computer player never fail this game
        //as a result, do not need to check if computer player will fail with 15 times


            if (gameBall.Bounds.IntersectsWith(paddleComputer.Bounds))
            {
                gameBall.Location = new Point(paddleComputer.Location.X - paddleComputer.Size.Width - 10, gameBall.Location.Y);
                xVel = -xVel;
            }
            //Check for player paddle.
            if (gameBall.Bounds.IntersectsWith(paddlePlayer.Bounds))
            {
                gameBall.Location = new Point(paddlePlayer.Location.X + gameBall.Size.Width, gameBall.Location.Y);
                xVel = -xVel;
            }
            //Check for left wall for human player 
            if (gameBall.Location.X < 0)
            {
                //if fail with 15 times
                if (plrScore == 14)
                {
                    //show a message to ask if want to continue or not
                    plrScoreDraw.Text = Convert.ToString(plrScore + 1);
                    //do not move the ball and computer paddle
                    gameTimer.Enabled = false;
                    //'show the cursor
                    System.Windows.Forms.Cursor.Show();
                    //'play a default system sound to alert
                    //play a default system sound to alert
                    // in VB, using My.Computer.Audio.PlaySystemSound(System.Media.SystemSounds.Asterisk)
                    SystemSounds.Asterisk.Play();
                    if (MessageBox.Show("Try again?", "Pong", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        //if continue tro play
                        gameTimer.Enabled = true;
                        //'both score set to zero
                        plrScore = 0;
                        plrScoreDraw.Text = Convert.ToString(plrScore);
                        compScore = 0;
                        compScoreDraw.Text = Convert.ToString(compScore);
                        System.Windows.Forms.Cursor.Hide();
                    }
                    else
                    {
                        Application.Exit();
                    }
                }
                //show the current fail times 
                plrScore += 1;
                //'show the current fail times 
                gameBall.Location = new Point(this.Size.Width / 2, this.Size.Height / 2);
                plrScoreDraw.Text = Convert.ToString(plrScore);
            }
            //Check for right wall.
            if (gameBall.Location.X > this.Width - gameBall.Size.Width - paddlePlayer.Width) {
                compScore += 1;

                gameBall.Location = new Point(this.Size.Width / 2, this.Size.Height / 2);
                compScoreDraw.Text = Convert.ToString(compScore);
             }
            //Set the computer player to move according to the ball's position."

            if (gameBall.Location.Y > 5 && gameBall.Location.Y < this.Height - 40 - paddlePlayer.Height) { 
                paddleComputer.Location = new Point(paddleComputer.Location.X, gameBall.Location.Y);
            }

        }

    }
}
