package Assignment_2;

public interface Utility {
    default int getId() {
        return 0;
    }
    default Submission getSubmission(){
        return new Submission(null);
    }
}

