package knox.frontend.models;

public class NordjyskeResult {
    private String passage;
    private String documentTitle;
    private String sourceDocument;
    private String score;

    public NordjyskeResult(String passage, String documentTitle, String sourceDocument, String score) {
        this.passage = passage;
        this.documentTitle = documentTitle;
        this.sourceDocument = sourceDocument;
        this.score = score;
    }

    public NordjyskeResult() {
    }

    public String getPassage() {
        return passage;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public String getSourceDocument() {
        return sourceDocument;
    }

    public String getScore() {
        return score;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public void setSourceDocument(String sourceDocument) {
        this.sourceDocument = sourceDocument;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "NordjyskeResult{" +
                "passage='" + passage + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", sourceDocument='" + sourceDocument + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
