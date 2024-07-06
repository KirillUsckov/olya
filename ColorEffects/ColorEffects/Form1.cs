using System;
using System.Drawing;
using System.Windows.Forms;
using Accord.Imaging.Filters;

namespace ColorEffects
{
    public partial class ColorEffects_Form : Form
    {
        // конфигурация окна для выбора файла
        private OpenFileDialog OFD = new OpenFileDialog
        {
            Multiselect = false, // выбор только 1 файла
            Filter = "Image files (*.jpg;*.png;*.gif;*.jpeg)|*.jpg;*.png;*.gif;*.jpeg", // доступные расширения
            Title = "Выбрать изображение" // установка заголовка окна
        };

        // конфигурация окна для сохранения файла
        private SaveFileDialog Save = new SaveFileDialog()
        {
            Filter = "JPG Image|*.jpg|PNG Image|*.png|GIF Image|*.gif",
            Title = "Сохранить изображение"
        };

        // Изображение без эффектов для отмены действий
        private Bitmap TempImagewWithoutEffect;
        // Текущее изображение
        private Bitmap TempImage;

        public ColorEffects_Form()
        {
            // Вызов метода для инициализации элементов формы и установки им параметров
            InitializeComponent();
        }

        // Метод, вызываемый при загрузке формы 
        private void ColorEffect_Form_Load(object sender, EventArgs e)
        {
            // установка дефолтного значения в ComboBox
            ColorEffect_ComboBox.SelectedIndex = 0;
        }

        // Метод, вызываемый кнопкой "Выбрать изображение"
        private void ChoosePicture(object sender, EventArgs e)
        {
            // Если пользователь выбрал картинку и нажал "Открыть"
            if (OFD.ShowDialog() == DialogResult.OK)
            {
                // Получение изображения из окна 
                Image Img = Image.FromStream(OFD.OpenFile());
                // Размещение изображения в буферы
                TempImage = new Bitmap(Img); // текущий буфер
                TempImagewWithoutEffect = (Bitmap)TempImage.Clone(); // буфер для отмены ч/б эффекта

                // помещение изображения в PictureBox
                Image_PictureBox.Image = new Bitmap(Img);
                // Установка доступности для всех эффектов
                ColorEffect_ComboBox.Enabled = true;
                RotateClockwise_Button.Enabled = true;
                RotateCounterClockwise_Button.Enabled = true;
                SaveImage_Button.Enabled = true;
                BlurCheckBox.Enabled = true;
            }
        }

        // Метод вызывается при нажатии на один из RadioButton
        private void ChangeSizeMode(object sender, EventArgs e)
        {
            // Если была нажата кнопка "Исходный размер"
            if (sender == NormalSizeMode_RadioButton)
            {
                Image_PictureBox.SizeMode = PictureBoxSizeMode.AutoSize;
            }
            // Если была нажата кнопка "Масштабирование"
            else if (sender == ZoomSizeMode_RadioButton)
            {
                // Панель - внешний элемент, нужный для маштабирования в окне
                Panel.VerticalScroll.Value = 0;
                Panel.HorizontalScroll.Value = 0;
                Image_PictureBox.SizeMode = PictureBoxSizeMode.Zoom;
                Image_PictureBox.Width = Panel.Width;
                Image_PictureBox.Height = Panel.Height;
            }
        }

        // Метод, вызываемый при изменении значения в ComboBox "Цвет"
        private void ChangeColorEffect(object sender, EventArgs e)
        {
            if (TempImage == null)
                return;
            switch (ColorEffect_ComboBox.SelectedIndex)
            {
                case 0:
                    // установка изображения без эффектов в буфер 
                    TempImage = (Bitmap)TempImagewWithoutEffect.Clone();
                    // установка изображения без эффектов в PictureBox 
                    Image_PictureBox.Image = (Bitmap)TempImage.Clone();
                    break;
                case 1:
                    // функция для применения инверсии к картинке
                    InvertColor();
                    break;
            }
            // Примеенение блюра (нужно, т.к. мы используем TempImagewWithoutEffect)
            Blur();
            //Обнолвение картинки
            Image_PictureBox.Invalidate();
        }

        // Функция дл яприменения инверсии цвета
        private void InvertColor()
        {
            Bitmap BM = new Bitmap(TempImage);
            // копирование картинки из TempImage в TempImagewWithoutEffect
            TempImagewWithoutEffect = (Bitmap)BM.Clone();
            int Height = BM.Height;
            int Width = BM.Width;
            // 2 вложенных цикла для прохождения по всем пикселям
            for (int y = 0; y < Height; y++)
            {
                for (int x = 0; x < Width; x++)
                {
                    // Получение пикселя по координатам
                    Color p = BM.GetPixel(x, y);

                    // альфа канал
                    int a = p.A;
                    // красный
                    int r = p.R;
                    // зеленый
                    int g = p.G;
                    // синий
                    int b = p.B;

                    // получение противоположного цвета для красного, зеленого и синего каналов
                    r = 255 - r;
                    g = 255 - g;
                    b = 255 - b;

                    // обновление пикселя по координатам с новыми знаечниями 
                    BM.SetPixel(x, y, Color.FromArgb(a, r, g, b));
                }
            }
            // копирование в текущий буфер полученного инвертированного изобржения
            TempImage = (Bitmap)BM.Clone();
            // Размещение TempImage в PictureBox
            Image_PictureBox.Image = TempImage;
        }

        // Метод, вызываемый при нажатии на кнопку "Против часовой"
        private void RotateCounterClockwise(object sender, EventArgs e)
        {
            // Вращение против часовой
            Rotate(sender, e, RotateFlipType.Rotate270FlipNone);
        }

        // Метод, вызываемый при нажатии на кнопку "По часовой"
        private void RotateClockwise(object sender, EventArgs e)
        {
            // Вращение по часовой
            Rotate(sender, e, RotateFlipType.Rotate90FlipNone);
        }

        private void Rotate(object sender, EventArgs e, RotateFlipType rotateFlipType)
        {
            // Вращение текущего буфера
            TempImage.RotateFlip(rotateFlipType);
            // Вращение буфера без эффектов
            TempImagewWithoutEffect.RotateFlip(rotateFlipType);
            // если выбран стиль отображения "Исходный размер"
            if (NormalSizeMode_RadioButton.Checked == true)
            {
                Image_PictureBox.Width = Image_PictureBox.Image.Width;
                Image_PictureBox.Height = Image_PictureBox.Image.Height;
            }
            Blur();
            Image_PictureBox.Invalidate();
        }

        // Метод, вызываемый при нажатии на кнопку "Сохранить результат"
        private void SaveResult(object sender, EventArgs e)
        {
            // Открытие окна
            Save.ShowDialog();
            // Если ввели имя файла
            if (Save.FileName != "")
            {
                // создание стрима для чтения/записи файла
                System.IO.FileStream fs = (System.IO.FileStream)Save.OpenFile();
                // получени из окна индекса выбранного типа файла
                switch (Save.FilterIndex)
                {
                    case 1:
                        this.Image_PictureBox.Image.Save(fs,
                          System.Drawing.Imaging.ImageFormat.Jpeg);
                        break;

                    case 2:
                        this.Image_PictureBox.Image.Save(fs,
                          System.Drawing.Imaging.ImageFormat.Png);
                        break;

                    case 3:
                        this.Image_PictureBox.Image.Save(fs,
                          System.Drawing.Imaging.ImageFormat.Gif);
                        break;
                }
                // закрытие потока
                fs.Close();
            }
        }

        // Метод, вызываемый во внутренних функциях
        private void Blur()
        {
            // Если стоит галочка напротив чекбокса с блюром, то эффект применяетеся
            if (BlurCheckBox.Checked)
            {
                ApplyGaussianBlur(1.2);
            }
            else
            {
                // Если галочки нет, то эффект снимается - текущеее изображение берется из буфера
                Image_PictureBox.Image = TempImage;
            }
        }

        // Метод, вызывающийся при нажатии на чекбокс Блюра
        private void SetBlur(object sender, EventArgs e)
        {
            // Если в чекбоксе галочка
            if (BlurCheckBox.Checked)
            {
                // применение блюра
                ApplyGaussianBlur(1.2);
            }
            else
            {
                // Отмена блюра - высталвение в PictureBox картинки из буфера
                Image_PictureBox.Image = TempImage;
            }
            //обнолвение картинки в PictureBox
            Image_PictureBox.Invalidate();
        }


        // Метод для установки блюра
        public void ApplyGaussianBlur(double sigma)
        {
            // Получение текущего изображения из буфера
            Bitmap sourceImage = new Bitmap(TempImage);
            // Создаем экземпляр фильтра размытия по Гауссу
            GaussianBlur filter = new GaussianBlur(sigma);
            // Применяем фильтр к изображению
            Bitmap blurredImage = filter.Apply(sourceImage);
            //Размещение получившегося изображения в PictureBox
            Image_PictureBox.Image = blurredImage;
        }
    }
}
