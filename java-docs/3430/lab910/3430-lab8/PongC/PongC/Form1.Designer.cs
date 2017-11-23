namespace PongC
{
    partial class pongMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.compScoreDraw = new System.Windows.Forms.Label();
            this.plrScoreDraw = new System.Windows.Forms.Label();
            this.paddlePlayer = new System.Windows.Forms.PictureBox();
            this.paddleComputer = new System.Windows.Forms.PictureBox();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.panel4 = new System.Windows.Forms.Panel();
            this.gameTimer = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.paddlePlayer)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.paddleComputer)).BeginInit();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // compScoreDraw
            // 
            this.compScoreDraw.AutoSize = true;
            this.compScoreDraw.Font = new System.Drawing.Font("Microsoft Sans Serif", 28F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.compScoreDraw.Location = new System.Drawing.Point(435, 29);
            this.compScoreDraw.Name = "compScoreDraw";
            this.compScoreDraw.Size = new System.Drawing.Size(59, 64);
            this.compScoreDraw.TabIndex = 0;
            this.compScoreDraw.Text = "0";
            // 
            // plrScoreDraw
            // 
            this.plrScoreDraw.AutoSize = true;
            this.plrScoreDraw.Font = new System.Drawing.Font("Microsoft Sans Serif", 28F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.plrScoreDraw.Location = new System.Drawing.Point(310, 29);
            this.plrScoreDraw.Name = "plrScoreDraw";
            this.plrScoreDraw.Size = new System.Drawing.Size(59, 64);
            this.plrScoreDraw.TabIndex = 1;
            this.plrScoreDraw.Text = "0";
            // 
            // paddlePlayer
            // 
            this.paddlePlayer.BackColor = System.Drawing.Color.LightGreen;
            this.paddlePlayer.Location = new System.Drawing.Point(0, 137);
            this.paddlePlayer.Name = "paddlePlayer";
            this.paddlePlayer.Size = new System.Drawing.Size(16, 128);
            this.paddlePlayer.TabIndex = 2;
            this.paddlePlayer.TabStop = false;
            // 
            // paddleComputer
            // 
            this.paddleComputer.BackColor = System.Drawing.Color.LightCoral;
            this.paddleComputer.Location = new System.Drawing.Point(764, 186);
            this.paddleComputer.Name = "paddleComputer";
            this.paddleComputer.Size = new System.Drawing.Size(16, 128);
            this.paddleComputer.TabIndex = 3;
            this.paddleComputer.TabStop = false;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.GradientInactiveCaption;
            this.panel1.Location = new System.Drawing.Point(399, 2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(3, 556);
            this.panel1.TabIndex = 4;
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.SystemColors.GradientInactiveCaption;
            this.panel2.Controls.Add(this.panel3);
            this.panel2.Location = new System.Drawing.Point(0, 15);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(400, 2);
            this.panel2.TabIndex = 5;
            // 
            // panel3
            // 
            this.panel3.Location = new System.Drawing.Point(330, 15);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(800, 2);
            this.panel3.TabIndex = 6;
            // 
            // panel4
            // 
            this.panel4.BackColor = System.Drawing.SystemColors.GradientInactiveCaption;
            this.panel4.Location = new System.Drawing.Point(330, 15);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(800, 2);
            this.panel4.TabIndex = 6;
            // 
            // gameTimer
            // 
            this.gameTimer.Enabled = true;
            this.gameTimer.Interval = 20;
            this.gameTimer.Tick += new System.EventHandler(this.gameTimer_Tick);
            // 
            // pongMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Highlight;
            this.ClientSize = new System.Drawing.Size(778, 544);
            this.Controls.Add(this.panel4);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.paddleComputer);
            this.Controls.Add(this.paddlePlayer);
            this.Controls.Add(this.plrScoreDraw);
            this.Controls.Add(this.compScoreDraw);
            this.Name = "pongMain";
            this.Text = "Pong";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.paddlePlayer)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.paddleComputer)).EndInit();
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label compScoreDraw;
        private System.Windows.Forms.Label plrScoreDraw;
        private System.Windows.Forms.PictureBox paddlePlayer;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.Timer gameTimer;
        private System.Windows.Forms.PictureBox paddleComputer;
    }
}

