package io.github.seujorgenochurras.color.symbol;

import java.util.ArrayList;
import java.util.List;

public class SymbolList {
    private final Symbol[] sortedSymbols;

    private int acceptableSymbolAccuracy = 4;


    public SymbolList(int listSize) {
        this.sortedSymbols = new Symbol[listSize - 1];
    }
    public SymbolList(int listSize, int acceptableCharAccurace){
        this.sortedSymbols = new Symbol[listSize - 1];
        this.acceptableSymbolAccuracy = acceptableCharAccurace;

    }



    public void addSymbol(Symbol symbol) {
        double newSymbolBrightness = symbol.getBrightness();

        int symbolShade = (int) Math.round(newSymbolBrightness / ((double) 256 /sortedSymbols.length));
        if(sortedSymbols.length -1 < symbolShade) return;


        Symbol currentSymbol = sortedSymbols[symbolShade];

        if (currentSymbol == null) {
            sortedSymbols[symbolShade] = symbol;
            return;
        }

        double currentBrightnessDelta = currentSymbol.getBrightness() - symbolShade;
        double newBrightnessDelta = newSymbolBrightness - symbolShade;

        if (currentBrightnessDelta > newBrightnessDelta) {
            sortedSymbols[symbolShade] = symbol;
        } else {
            for (int i = symbolShade; i < symbolShade + acceptableSymbolAccuracy; i++) {
                if(i > sortedSymbols.length-1) break;

                if (sortedSymbols[i] == null ) {
                    sortedSymbols[i] = symbol;
                    break;
                }
            }
        }
    }

    public Symbol[] getSymbolsAsArray() {
        return sortedSymbols;
    }

    public String[] getSymbolsAsStringArray() {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < sortedSymbols.length - 1; i++) {
            if(sortedSymbols[i] == null) continue;
           stringList.add(sortedSymbols[i].getData());
        }
        return stringList.toArray(new String[stringList.size()-1]);
    }

    public int size() {
        int size = 0;
        for(int i = 0; i < sortedSymbols.length-1; i++){
            if(sortedSymbols[i] == null) {
                continue;
            }
            size++;
        }
        return size;
    }

    @Override
    public String toString() {

        return "SymbolList{" +
                "sortedSymbols=" + getSortedSymbolsAsString() +
                '}';
    }

    private String getSortedSymbolsAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Symbol symbol : sortedSymbols) {
            if (symbol == null) continue;
            stringBuilder.append("\"").append(symbol.getData()).append("\",");
        }
        return stringBuilder.toString();
    }
}
