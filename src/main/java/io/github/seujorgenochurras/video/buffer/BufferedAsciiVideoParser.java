package io.github.seujorgenochurras.video.buffer;

import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserConfig;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BufferedAsciiVideoParser {

    private final ParserConfig parserConfig;
    private final PixelAnalyzerBuffer pixelAnalyzerBuffer;

    private final Queue<String> asciiArtQueue = new LinkedBlockingQueue<>();

    private final int maxBufferedFrames;

    public BufferedAsciiVideoParser(ParserConfig parserConfig, PixelAnalyzerBuffer pixelAnalyzerBuffer, int maxBufferedFrames) {
        this.parserConfig = parserConfig;
        this.pixelAnalyzerBuffer = pixelAnalyzerBuffer;
        this.maxBufferedFrames = maxBufferedFrames;
    }


    public BufferedAsciiVideoParser(ParserConfig parserConfig, PixelAnalyzerBuffer pixelAnalyzerBuffer) {
        this.parserConfig = parserConfig;
        this.pixelAnalyzerBuffer = pixelAnalyzerBuffer;
        this.maxBufferedFrames = 250;
    }

    public void startQueue() {
        Queue<BetterImage> framesQueue = pixelAnalyzerBuffer.getQueue();
        new Thread(() -> {
            long currentFrame = 0;
            while (currentFrame < pixelAnalyzerBuffer.getVideoFileLength()) {

                BetterImage frame = framesQueue.peek();
                if(frame == null || (asciiArtQueue.size() >= maxBufferedFrames)) {
                    continue;
                }
                asciiArtQueue.offer(AsciiParser.parse(framesQueue.poll(), parserConfig));
            }
        }).start();
    }

    public Queue<String> getAsciiArtQueue() {
        return asciiArtQueue;
    }
}
