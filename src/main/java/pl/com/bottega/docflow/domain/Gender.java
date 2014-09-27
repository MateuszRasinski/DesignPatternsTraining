package pl.com.bottega.docflow.domain;

public enum Gender {
    M {
        @Override
        public Object accept(Visitor visitor) {
            return visitor.visitM(this);
        }
    }, F {
        @Override
        public Object accept(Visitor visitor) {
            return visitor.visitF(this);
        }
    }, CR {
        @Override
        public Object accept(Visitor visitor) {
            return visitor.visitCR(this);
        }
    }, CRY {
        @Override
        public Object accept(Visitor visitor) {
            return visitor.visitCRY(this);
        }
    };

    public abstract Object accept(Visitor visitor);

    static interface Visitor {
        String visitM(Gender gender);
        String visitF(Gender gender);
        String visitCR(Gender gender);
        String visitCRY(Gender gender);
    }

    static class ToStringVisitor implements Visitor {

        @Override
        public String visitM(Gender gender) {
            return "Pan " + gender.toString();
        }

        @Override
        public String visitF(Gender gender) {
            return "Pan " + gender.toString();
        }

        @Override
        public String visitCR(Gender gender) {
            return "?? " + gender.toString();
        }

        @Override
        public String visitCRY(Gender gender) {
            return "NOT YET: " + gender.toString();
        }
    }

    public void main() {
        String string = (String) Gender.M.accept(new ToStringVisitor());
    }
}
