public class Printer {

    private int sheets;
    private int toner;

    public Printer(int sheets, int toner){
        this.sheets = sheets;
        this.toner = toner;
    }

    public int getSheets() {
        return sheets;
    }

    public int getToner(){
        return toner;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }

    public void setToner(int toner){
        this.toner = toner;
    }

    public int calculateTotalPagesToPrint(int pages, int copies) {
        return pages*copies;
    }

    public boolean checkEnoughPaper(int sheets, int pagesToPrint) {
        if (this.sheets >= pagesToPrint) {
            return true;
        } else {
            return false;
        }
    }

    public void changePaperLeft(int sheets, int pagesToPrint){
        this.sheets = sheets - pagesToPrint;
    }

    public void changeTonerLeft(int toner, int pagesToPrint){
        this.toner = toner-pagesToPrint;
    }

    public void print(int pages, int copies){
        int pagesToPrint = this.calculateTotalPagesToPrint(pages, copies);
        boolean okToPrint = this.checkEnoughPaper(pages, pagesToPrint);
        if (!okToPrint){
            return;
        } else{
            changePaperLeft(this.sheets, pagesToPrint);
            changeTonerLeft(this.toner, pagesToPrint);
        }
    }


}
