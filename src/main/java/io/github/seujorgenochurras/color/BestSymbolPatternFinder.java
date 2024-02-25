package io.github.seujorgenochurras.color;

import io.github.seujorgenochurras.color.symbol.Symbol;
import io.github.seujorgenochurras.color.symbol.SymbolList;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicLong;

public class BestSymbolPatternFinder {


    /**
     * Overloaded method of {@link BestSymbolPatternFinder#findBestPattern(int, int, String...)}
     */
    public static SymbolList findBestPattern(String... chars) {
        return findBestPattern(255, chars);
    }

    /**
     * Overloaded method of {@link BestSymbolPatternFinder#findBestPattern(int, int, String...)}
     */
    public static SymbolList findBestPattern(int maxSymbols, String... chars) {

        return findBestPattern(10, maxSymbols, chars);
    }

    /**
     * Finds the best pattern given any unsorted symbols
     *
     * @param symbolAccuracy amount of preciseness of symbols representation, for example: <br>
     *                       symbolAcurracy of 2 means that a symbol can either represent its brightness value +1 or -1,
     *                       <b>lower means high precision</b>
     * @param maxSymbols     maximum amount of symbols
     * @param chars          unsortedSymbols
     * @return the best symbol pattern possible in the font Fira Mono
     */
    //TODO refactor this non-sense shit
    public static SymbolList findBestPattern(int symbolAccuracy, int maxSymbols, String... chars) {
        int width = 50;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        var g2d = image.getGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.WHITE);

        SymbolList symbolList = new SymbolList(maxSymbols, symbolAccuracy);
        for (String symbol : chars) {
            if (symbolList.size() > maxSymbols) break;

            g2d = image.getGraphics();

            Font font = new Font("Fira Mono", Font.BOLD, 40);
            g2d.setFont(font);
            FontMetrics fm = g2d.getFontMetrics();

            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, width, height);
            g2d.setColor(Color.WHITE);

            int textWidth = fm.stringWidth(symbol);
            int textHeight = fm.getHeight();
            int x = (width - textWidth) / 2;
            int y = ((height - textHeight) / 2) + fm.getAscent();

            g2d.drawString(symbol, x, y);
            double avgBright = getAvgPixelBrightness(image);

            symbolList.addSymbol(new Symbol(symbol, avgBright));
            g2d.dispose();
        }
        return symbolList;
    }

    private static double getAvgPixelBrightness(BufferedImage image) {
        BetterImage betterImage = new BetterImage(image);

        AtomicLong avgPixelBrightness = new AtomicLong();
        betterImage.getPixels().forEach(pixel -> {
            var color = pixel.color;

            int red = color.getRed().asDecimal();
            int green = color.getGreen().asDecimal();
            int blue = color.getBlue().asDecimal();

            long pixelBrightness = Algorithms.BRIGHTEST_PIXEL.getAlgorithm().getBrightnessValue(red, green, blue);
            avgPixelBrightness.addAndGet(pixelBrightness);

        });
        return (double) avgPixelBrightness.get() / betterImage.getPixels().size();
    }

}
