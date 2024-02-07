# Why? 
A long time ago I started using [neofetch](https://github.com/dylanaraps/neofetch) which is a command for those who uses terminal, and I saw an ASCII art of my linux distro. <br>
After that, I thought for a while and had the brilliant idea of making an ASCII art generator for java.

## Wait can I also do video???? 
  Kinda off, if you're on linux (**and you can only do it on linux**) you need to install a library called [video4j](https://github.com/metaloom/video4j). <br>
  Well, actually you don't need to install the library, just look for something called **libopencv_java460**<br>


# How do I do it?
  You should probably take a look at the code first:<br>
  ```java
    private static final String[] symbols = {"L", "U", "C", "A", "S"};

    private static final ParserConfig parserConfig = ParserBuilder.startBuild()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .scaled()
              .algorithm(PixelScaleAlgorithm.SMOOTH)
              .height(30)
              .width(80)
            .getScale()
            .symbols(symbols)
            .withColor(new AnsiColorAlgorithm())
            .build();

  String asciiArt = AsciiParser.parse(imagePath, parserConfig);      

```
  As you can see, there're lots of different configurations for your ASCII art, I'll list some of the most important stuff here:<br>
  - parserAlgorithm
      - This is the algorithm that defines how to deal with brightness, basicly speaking the HUMAN_EYE_ALGORITHM is the best for humans
  - scaled
    - This is where you define if you want to scale down (or up) your image, the scale algorithm doesn't really change nothing
  - symbols
    - Symbols to use in the ASCII art from darkest to brightest, you can use my symbolPatternFinder to automatically generate symbols in ""perfect"" order
      ```java
        private static final int totalSymbols = 150; // It really doesnt make any sense to have a symbol list with more than 255 elements
        private static final String[] unorderedSymbols = StringUtils.getUTFChars(32, 1600);
        private String[] symbols = BestSymbolPatternFinder.findBestPattern(totalSymbols, unorderedSymbols).toArray();
      ```
  
  - withColor
    - This is the color algorithm, yes you read it right, we have colors. More specifically ANSI colors, if you have no idea what ANSI is,
      it is basically a standart on most of terminals that allows you to make some pretty awesome stuff, like playing videos with characters on your terminal or even colorize them.<br>
      for now there are only 2 colored algorithms, the normal ANSI and the ANSI with tones
