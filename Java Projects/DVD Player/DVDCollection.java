package sample;

public class DVDCollection {
    public static final int     MAX_DVDS = 100;
    private final DVD[]   dvds;
    private int     dvdCount;
    private final DVDView[] observers;
    private int       numObservers;
    private final int       selectedDVD;

    public DVDCollection() {
        dvds         = new DVD[MAX_DVDS];
        observers    = new DVDView[3];
        numObservers = 0;
        selectedDVD  = -1;
    }

    public DVD[] getDvds() {
        return dvds;
    }

    public DVD[] getDVDList() {
        DVD[] list = new DVD[dvdCount];
        System.arraycopy(dvds, 0, list, 0, dvdCount);
        return list;
    }

    public int getDvdCount() {
        return dvdCount;
    }

    public String toString() {
        return ("DVD Collection of size " + dvdCount);
    }

    public void add(DVD aDvd) {
        if (dvdCount < MAX_DVDS) {
            dvds[dvdCount++] = aDvd;
        }
        updateObservers();
    }

    public boolean remove(String title) {
        for (int i=0; i<dvdCount; i++) {
            DVD d = dvds[i];
            if (dvds[i].getTitle().equals(title)) {
                dvds[i] = dvds[dvdCount-1];
                dvdCount--;
                updateObservers();
                return true;
            }
        }
        return false;
    }

    public static DVDCollection example1() {
        DVDCollection c = new DVDCollection();
        c.add(new DVD("If I Was a Student", 2007, 65));
        c.add(new DVD("Don't Eat Your Pencil !", 1984, 112));
        c.add(new DVD("The Exam", 2001, 180));
        c.add(new DVD("Tutorial Thoughts", 2003, 128));
        c.add(new DVD("Fried Monitors", 1999, 94));
        return c;
    }

    public void addObserver(DVDView v) {
        if (numObservers < observers.length) {
            observers[numObservers++] = v;
        }
    }

    public void updateObservers() {
        for (int i = 0; i < numObservers; i++) {
            System.out.println(observers[i]);
            observers[i].update(this, selectedDVD);
        }
    }
}
