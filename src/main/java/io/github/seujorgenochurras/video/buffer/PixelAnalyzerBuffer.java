package io.github.seujorgenochurras.video.buffer;

import io.github.seujorgenochurras.image.BetterImage;
import io.metaloom.video4j.VideoFile;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PixelAnalyzerBuffer {

    private final VideoFile videoFile;

    private final int maxBufferedPixels;
    private final Queue<BetterImage> pixelGroupQueue = new LinkedBlockingQueue<>();

    public PixelAnalyzerBuffer(VideoFile videoFile) {
        this.videoFile = videoFile;
        this.maxBufferedPixels = 250;
    }

    public PixelAnalyzerBuffer(VideoFile videoFile, int maxBufferedPixels) {
        this.videoFile = videoFile;
        this.maxBufferedPixels = maxBufferedPixels;
    }

    public void startQueue() {
        new Thread(() -> {
            while (videoFile.currentFrame() < videoFile.length()) {
                if (pixelGroupQueue.size() >= maxBufferedPixels) {
                    continue;
                }
                BetterImage betterImage = new BetterImage(videoFile.frameToImage());
                pixelGroupQueue.offer(betterImage);
            }
        }).start();
    }

    public Queue<BetterImage> getQueue() {
        return pixelGroupQueue;
    }

    public long getVideoFileLength() {
        return videoFile.length();
    }

}
