/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Sidney
 */
public class filtro {
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    
    public  BufferedImage banda (BufferedImage img, int banda){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);
        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                if(banda == 0){
                    Color novaCor = new Color(red,0,0);
                    imgSaida.setRGB(linha,coluna,novaCor.getRGB());

                } else if(banda == 1) {
                    Color novaCor = new Color(0,green,0);
                    imgSaida.setRGB(linha,coluna,novaCor.getRGB());

                } else if(banda == 2){
                    Color novaCor = new Color(0,0,blue);
                    imgSaida.setRGB(linha,coluna,novaCor.getRGB());

                } else {
                    throw new Error("Invalid Banda");
                }

            }
        }
        return imgSaida;
    }

    public  BufferedImage aumentoDeTonalidade (BufferedImage img, int banda, int aumento){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                if(banda == 0){
                    red += aumento;
                    if(red > 255) red = 255;
                }

                if(banda == 1){
                    green += aumento;
                    if(green > 255)green = 255;
                }

                if(banda == 2){
                    blue += aumento;
                    if(blue > 255)blue = 255;
                }

                Color novaCor = new Color(red,green,blue);
                imgSaida.setRGB(linha,coluna,novaCor.getRGB());
            }
        }
        return imgSaida;
    }
//aula 07/04
    public  BufferedImage grayScale (BufferedImage img){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                int media = (red + green + blue) / 3;

                Color novaCor = new Color(media,media,media);
                imgSaida.setRGB(linha,coluna,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public  BufferedImage grayScaleBanda (BufferedImage img, int bandaColor){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);
                int choice = 0;

                if(bandaColor == 0){
                    choice = cor.getRed();

                } else if(bandaColor == 1) {
                    choice = cor.getGreen();

                } else if(bandaColor == 2){
                    choice = cor.getBlue();

                } else {
                    throw new Error("Invalid Banda");
                }

                Color novaCor = new Color(choice,choice,choice);
                imgSaida.setRGB(linha,coluna,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public  BufferedImage negative (BufferedImage img){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                Color novaCor = new Color( 255 - red, 255 - green, 255 -blue);
                imgSaida.setRGB(linha,coluna,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

//14/07
    public  BufferedImage binarizacao (BufferedImage img, int limiarValue){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);
                Color novaCor;
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                int media = (red + green + blue) / 3;

                if( media > limiarValue){
                    novaCor = new Color(255 ,255,255);
                } else {
                    novaCor = new Color(0,0,0);
                }

                imgSaida.setRGB(linha,coluna,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public  BufferedImage brilhoAditivo (BufferedImage img, int valor){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < altura; linha++){
            for(int coluna = 0; coluna < largura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                red += valor;
                if(red > 255 && red >= 0) red = 255;

                green += valor;
                if(green > 255  && green >= 0)green = 255;

                blue += valor;
                if(blue > 255  && blue >= 0)blue = 255;

                Color novaCor = new Color(red,green,blue);

                imgSaida.setRGB(linha,coluna,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public  BufferedImage brilhoMultiplicativo (BufferedImage img, int valor){
        int largura = img.getWidth();
        int altura =  img.getHeight();
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                red *= valor;
                if(red > 255 && red >= 0) red = 255;

                green *= valor;
                if(green > 255  && green >= 0)green = 255;

                blue *= valor;
                if(blue > 255 && blue >= 0)blue = 255;

                Color novaCor = new Color(red,green,blue);

                imgSaida.setRGB(linha,coluna,novaCor.getRGB());
            }
        }
        return imgSaida;
    }
    
    public  BufferedImage yiq2RGB (double[][][] estrutura){
        int largura = estrutura.length;
        int altura =  estrutura[0].length;

        int[][][] rgb = new int[largura][altura][3];
        BufferedImage imgSaida = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){

                double y = estrutura[linha][coluna][0];
                double i = estrutura[linha][coluna][1];
                double q = estrutura[linha][coluna][2];

                rgb[linha][coluna][0] = (int) ((1.000 * y) + (0.956 * i) + (0.620 * q));
                rgb[linha][coluna][1] = (int) ((1.000 * y) - (0.272 * i) - (0.647 * q));
                rgb[linha][coluna][2] = (int) ((1.000 * y) - (1.108 * i) + (1.704 * q));
                
                if( rgb[linha][coluna][0] > 255){
                    rgb[linha][coluna][0] = 255;
                    
                } else if ( rgb[linha][coluna][0] < 0){
                    rgb[linha][coluna][0] = 0;
                    
                }
                
                if( rgb[linha][coluna][1] > 255){
                    rgb[linha][coluna][1] = 255;
                    
                } else if ( rgb[linha][coluna][1] < 0){
                    rgb[linha][coluna][1] = 0;
                    
                }
                
                if( rgb[linha][coluna][2] > 255){
                    rgb[linha][coluna][2] = 255;
                    
                } else if ( rgb[linha][coluna][2] < 0){
                    rgb[linha][coluna][2] = 0;
                    
                }
                
                Color cor = new Color(rgb[linha][coluna][0], rgb[linha][coluna][1], rgb[linha][coluna][2]);

                imgSaida.setRGB(linha,coluna,cor.getRGB());
            }
        }

        return imgSaida;
    }
    
     public double[][][] RGB2yiq(BufferedImage img){
        int largura = img.getWidth();
        int altura =  img.getHeight();

        double[][][] estrutura = new double[largura][altura][3];

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                int rgb = img.getRGB(linha, coluna);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                estrutura[linha][coluna][0] = (0.299 * red) + (0.587 * green) + (0.114 * blue);
                estrutura[linha][coluna][1] = (0.596 * red) - ( 0.275 * green) - ( 0.321 * blue);
                estrutura[linha][coluna][2] = (0.212  * red) - (0.523 * green) + (0.311 * blue);
            }
        }

        return estrutura;
    }

    public double[][][] brilhoAditivoY (double[][][] estrutura, double valor){
        int largura = estrutura.length;
        int altura = estrutura[0].length;

        double[][][] yiq = new double[largura][altura][3];

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                yiq[linha][coluna][0] = estrutura[linha][coluna][0] + valor;
                yiq[linha][coluna][1] = estrutura[linha][coluna][1];
                yiq[linha][coluna][2] = estrutura[linha][coluna][2];
            }
        }
        return yiq;
    }

    public double[][][] brilhoMultiplicativoY (double[][][] estrutura, double valor){
        int largura = estrutura.length;
        int altura = estrutura[0].length;

        double[][][] yiq = new double[largura][altura][3];

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                yiq[linha][coluna][0] = estrutura[linha][coluna][0] * valor;
                yiq[linha][coluna][1] = estrutura[linha][coluna][1];
                yiq[linha][coluna][2] = estrutura[linha][coluna][2];
            }
        }
        return yiq;
    }

    public double[][][] negativeY (double[][][] estrutura){
        int largura = estrutura.length;
        int altura = estrutura[0].length;

        double[][][] yiq = new double[largura][altura][3];

        for(int linha=0; linha < largura; linha++){
            for(int coluna = 0; coluna < altura; coluna++){
                yiq[linha][coluna][0] = 255 - estrutura[linha][coluna][0];
                yiq[linha][coluna][1] = estrutura[linha][coluna][1];
                yiq[linha][coluna][2] = estrutura[linha][coluna][2];
            }
        }
        return yiq;
    }
}
