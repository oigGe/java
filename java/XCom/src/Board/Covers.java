package Board;

public class Covers {

    Cover[] covers;


    public Covers(int[] coverInt) {

        this.covers = new Cover[]{new Cover(),new Cover(),new Cover(),new Cover()};
        setCovers(coverInt);

    }

    private void setCovers(int[] coverInt) {
        for (int i = 0; i < this.covers.length; i++) {
            setCover(this.covers[i], coverInt[i]);
        }
    }

    private void setCover(Cover cover, int whichCoverHeight) {

        switch (whichCoverHeight) {
            case 1:
                cover.setCoverType(false);
                break;
            case 2:
                cover.setCoverType(true);
                break;
            case 0:
                delete(cover);
                break;
        }
    }

    private void delete(Cover cover){
        for (int i = 0; i < covers.length; i++){
           if (covers[i]== cover){
               covers[i] = null;
           }
        }
    }


    public class Cover {

        private final int HIGH_HIT_POINTS = 100;
        private final int MEDIUM_HIT_POINTS = 50;
        private boolean isHighCover;
        private int hitPoints;

        public Cover(boolean isHighCover) {
            this.isHighCover = isHighCover;
            if (isHighCover) {
                this.hitPoints = HIGH_HIT_POINTS;
            } else {
                this.hitPoints = MEDIUM_HIT_POINTS;
            }
        }

        public Cover() {
        }

        public void setCoverType(boolean isHighCover){
            this.isHighCover = isHighCover;
            if (isHighCover) {
                this.hitPoints = HIGH_HIT_POINTS;
            } else {
                this.hitPoints = MEDIUM_HIT_POINTS;
            }
        }

        public void setNull(){

        }
    }
}
