﻿using System;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Windows.Forms;

namespace PongC
{
    class RoundedPictureBox : PictureBox
    {

        public RoundedPictureBox()
        {
            this.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.SizeMode = PictureBoxSizeMode.StretchImage;
        }
        protected override void OnResize(EventArgs e)
        {
            base.OnResize(e);
            using (var gp = new GraphicsPath())
            {
                gp.AddEllipse(new Rectangle(0, 0, this.Width - 1, this.Height - 1));
                this.Region = new Region(gp);
            }
        }

    }
}
