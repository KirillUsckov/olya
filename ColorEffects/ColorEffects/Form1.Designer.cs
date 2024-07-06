namespace ColorEffects {
    partial class ColorEffects_Form {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing) {
            if(disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent() {
            this.ChoosePicture_Button = new System.Windows.Forms.Button();
            this.NormalSizeMode_RadioButton = new System.Windows.Forms.RadioButton();
            this.ZoomSizeMode_RadioButton = new System.Windows.Forms.RadioButton();
            this.SizeMode_Label = new System.Windows.Forms.Label();
            this.ColorEffect_Label = new System.Windows.Forms.Label();
            this.ColorEffect_ComboBox = new System.Windows.Forms.ComboBox();
            this.SaveImage_Button = new System.Windows.Forms.Button();
            this.RotateClockwise_Button = new System.Windows.Forms.Button();
            this.RotateCounterClockwise_Button = new System.Windows.Forms.Button();
            this.Rotate_Label = new System.Windows.Forms.Label();
            this.Panel = new System.Windows.Forms.Panel();
            this.Image_PictureBox = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.BlurCheckBox = new System.Windows.Forms.CheckBox();
            this.Panel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Image_PictureBox)).BeginInit();
            this.SuspendLayout();
            // 
            // ChoosePicture_Button
            // 
            this.ChoosePicture_Button.Location = new System.Drawing.Point(874, 13);
            this.ChoosePicture_Button.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.ChoosePicture_Button.Name = "ChoosePicture_Button";
            this.ChoosePicture_Button.Size = new System.Drawing.Size(181, 27);
            this.ChoosePicture_Button.TabIndex = 0;
            this.ChoosePicture_Button.Text = "Выбрать изображение";
            this.ChoosePicture_Button.UseVisualStyleBackColor = true;
            this.ChoosePicture_Button.Click += new System.EventHandler(this.ChoosePicture);
            // 
            // NormalSizeMode_RadioButton
            // 
            this.NormalSizeMode_RadioButton.AutoSize = true;
            this.NormalSizeMode_RadioButton.Checked = true;
            this.NormalSizeMode_RadioButton.Location = new System.Drawing.Point(875, 75);
            this.NormalSizeMode_RadioButton.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.NormalSizeMode_RadioButton.Name = "NormalSizeMode_RadioButton";
            this.NormalSizeMode_RadioButton.Size = new System.Drawing.Size(144, 20);
            this.NormalSizeMode_RadioButton.TabIndex = 2;
            this.NormalSizeMode_RadioButton.TabStop = true;
            this.NormalSizeMode_RadioButton.Text = "Исходный размер";
            this.NormalSizeMode_RadioButton.UseVisualStyleBackColor = true;
            this.NormalSizeMode_RadioButton.Click += new System.EventHandler(this.ChangeSizeMode);
            // 
            // ZoomSizeMode_RadioButton
            // 
            this.ZoomSizeMode_RadioButton.AutoSize = true;
            this.ZoomSizeMode_RadioButton.Location = new System.Drawing.Point(875, 98);
            this.ZoomSizeMode_RadioButton.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.ZoomSizeMode_RadioButton.Name = "ZoomSizeMode_RadioButton";
            this.ZoomSizeMode_RadioButton.Size = new System.Drawing.Size(140, 20);
            this.ZoomSizeMode_RadioButton.TabIndex = 3;
            this.ZoomSizeMode_RadioButton.Text = "Масштабировать";
            this.ZoomSizeMode_RadioButton.UseVisualStyleBackColor = true;
            this.ZoomSizeMode_RadioButton.Click += new System.EventHandler(this.ChangeSizeMode);
            // 
            // SizeMode_Label
            // 
            this.SizeMode_Label.AutoSize = true;
            this.SizeMode_Label.Location = new System.Drawing.Point(871, 55);
            this.SizeMode_Label.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.SizeMode_Label.Name = "SizeMode_Label";
            this.SizeMode_Label.Size = new System.Drawing.Size(140, 16);
            this.SizeMode_Label.TabIndex = 4;
            this.SizeMode_Label.Text = "Режим отображения";
            // 
            // ColorEffect_Label
            // 
            this.ColorEffect_Label.AutoSize = true;
            this.ColorEffect_Label.Location = new System.Drawing.Point(872, 287);
            this.ColorEffect_Label.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.ColorEffect_Label.Name = "ColorEffect_Label";
            this.ColorEffect_Label.Size = new System.Drawing.Size(39, 16);
            this.ColorEffect_Label.TabIndex = 8;
            this.ColorEffect_Label.Text = "Цвет";
            // 
            // ColorEffect_ComboBox
            // 
            this.ColorEffect_ComboBox.Enabled = false;
            this.ColorEffect_ComboBox.FormattingEnabled = true;
            this.ColorEffect_ComboBox.Items.AddRange(new object[] {
            "Нет",
            "Негатив"});
            this.ColorEffect_ComboBox.Location = new System.Drawing.Point(874, 307);
            this.ColorEffect_ComboBox.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.ColorEffect_ComboBox.Name = "ColorEffect_ComboBox";
            this.ColorEffect_ComboBox.Size = new System.Drawing.Size(180, 24);
            this.ColorEffect_ComboBox.TabIndex = 9;
            this.ColorEffect_ComboBox.SelectedIndexChanged += new System.EventHandler(this.ChangeColorEffect);
            // 
            // SaveImage_Button
            // 
            this.SaveImage_Button.Enabled = false;
            this.SaveImage_Button.Location = new System.Drawing.Point(881, 430);
            this.SaveImage_Button.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SaveImage_Button.Name = "SaveImage_Button";
            this.SaveImage_Button.Size = new System.Drawing.Size(183, 27);
            this.SaveImage_Button.TabIndex = 10;
            this.SaveImage_Button.Text = "Сохранить результат";
            this.SaveImage_Button.UseVisualStyleBackColor = true;
            this.SaveImage_Button.Click += new System.EventHandler(this.SaveResult);
            // 
            // RotateClockwise_Button
            // 
            this.RotateClockwise_Button.Enabled = false;
            this.RotateClockwise_Button.Location = new System.Drawing.Point(875, 248);
            this.RotateClockwise_Button.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.RotateClockwise_Button.Name = "RotateClockwise_Button";
            this.RotateClockwise_Button.Size = new System.Drawing.Size(181, 27);
            this.RotateClockwise_Button.TabIndex = 14;
            this.RotateClockwise_Button.Text = "По часовой";
            this.RotateClockwise_Button.UseVisualStyleBackColor = true;
            this.RotateClockwise_Button.Click += new System.EventHandler(this.RotateClockwise);
            // 
            // RotateCounterClockwise_Button
            // 
            this.RotateCounterClockwise_Button.Enabled = false;
            this.RotateCounterClockwise_Button.Location = new System.Drawing.Point(875, 213);
            this.RotateCounterClockwise_Button.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.RotateCounterClockwise_Button.Name = "RotateCounterClockwise_Button";
            this.RotateCounterClockwise_Button.Size = new System.Drawing.Size(181, 27);
            this.RotateCounterClockwise_Button.TabIndex = 15;
            this.RotateCounterClockwise_Button.Text = "Против часовой";
            this.RotateCounterClockwise_Button.UseVisualStyleBackColor = true;
            this.RotateCounterClockwise_Button.Click += new System.EventHandler(this.RotateCounterClockwise);
            // 
            // Rotate_Label
            // 
            this.Rotate_Label.AutoSize = true;
            this.Rotate_Label.Location = new System.Drawing.Point(871, 194);
            this.Rotate_Label.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.Rotate_Label.Name = "Rotate_Label";
            this.Rotate_Label.Size = new System.Drawing.Size(79, 16);
            this.Rotate_Label.TabIndex = 16;
            this.Rotate_Label.Text = "Повернуть";
            // 
            // Panel
            // 
            this.Panel.AutoScroll = true;
            this.Panel.Controls.Add(this.Image_PictureBox);
            this.Panel.Location = new System.Drawing.Point(9, 15);
            this.Panel.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Panel.Name = "Panel";
            this.Panel.Size = new System.Drawing.Size(853, 443);
            this.Panel.TabIndex = 13;
            // 
            // Image_PictureBox
            // 
            this.Image_PictureBox.Location = new System.Drawing.Point(0, 0);
            this.Image_PictureBox.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Image_PictureBox.Name = "Image_PictureBox";
            this.Image_PictureBox.Size = new System.Drawing.Size(640, 360);
            this.Image_PictureBox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.AutoSize;
            this.Image_PictureBox.TabIndex = 1;
            this.Image_PictureBox.TabStop = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(874, 345);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(70, 16);
            this.label1.TabIndex = 17;
            this.label1.Text = "Эффекты";
            // 
            // BlurCheckBox
            // 
            this.BlurCheckBox.AutoSize = true;
            this.BlurCheckBox.Enabled = false;
            this.BlurCheckBox.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.BlurCheckBox.Location = new System.Drawing.Point(874, 365);
            this.BlurCheckBox.Margin = new System.Windows.Forms.Padding(4);
            this.BlurCheckBox.Name = "BlurCheckBox";
            this.BlurCheckBox.Size = new System.Drawing.Size(91, 20);
            this.BlurCheckBox.TabIndex = 18;
            this.BlurCheckBox.Text = "Размытие";
            this.BlurCheckBox.UseVisualStyleBackColor = true;
            this.BlurCheckBox.CheckedChanged += new System.EventHandler(this.SetBlur);
            // 
            // ColorEffects_Form
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1077, 470);
            this.Controls.Add(this.BlurCheckBox);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.Rotate_Label);
            this.Controls.Add(this.RotateCounterClockwise_Button);
            this.Controls.Add(this.RotateClockwise_Button);
            this.Controls.Add(this.Panel);
            this.Controls.Add(this.SaveImage_Button);
            this.Controls.Add(this.ColorEffect_ComboBox);
            this.Controls.Add(this.ColorEffect_Label);
            this.Controls.Add(this.SizeMode_Label);
            this.Controls.Add(this.ZoomSizeMode_RadioButton);
            this.Controls.Add(this.NormalSizeMode_RadioButton);
            this.Controls.Add(this.ChoosePicture_Button);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.MaximizeBox = false;
            this.Name = "ColorEffects_Form";
            this.ShowIcon = false;
            this.Text = "Цветовые эффекты";
            this.Load += new System.EventHandler(this.ColorEffect_Form_Load);
            this.Panel.ResumeLayout(false);
            this.Panel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Image_PictureBox)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button ChoosePicture_Button;
        private System.Windows.Forms.RadioButton NormalSizeMode_RadioButton;
        private System.Windows.Forms.RadioButton ZoomSizeMode_RadioButton;
        private System.Windows.Forms.Label SizeMode_Label;
        private System.Windows.Forms.Label ColorEffect_Label;
        private System.Windows.Forms.ComboBox ColorEffect_ComboBox;
        private System.Windows.Forms.Button SaveImage_Button;
        private System.Windows.Forms.Button RotateClockwise_Button;
        private System.Windows.Forms.Button RotateCounterClockwise_Button;
        private System.Windows.Forms.Label Rotate_Label;
        private System.Windows.Forms.Panel Panel;
        private System.Windows.Forms.PictureBox Image_PictureBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox BlurCheckBox;
    }
}

