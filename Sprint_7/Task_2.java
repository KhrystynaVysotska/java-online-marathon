import java.util.NoSuchElementException;

class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter = 0;
        
        private Iterator() {
            
        }
        
        public void incrementCounter() {
            counter++;
        }
        
        public boolean hasNext() {
           if (counter < names.length) {
                return true;
            } else {
                return false;
            }
        }
        
        public String next() {
           if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return names[counter++];
        }
    }
}
