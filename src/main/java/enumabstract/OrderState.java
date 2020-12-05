package enumabstract;

public enum OrderState implements Deletable {
    NEW {
        @Override
        public boolean canDelete() {
            return true;
        }
    },

    CONFIRMED {
        @Override
        public boolean canDelete() {
            return true;
        }
    },

    PREPARED {
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    ONBOARD {
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    DELIVERED {
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    RETURNED {
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    DELETED {
        @Override
        public boolean canDelete() {
            return false;
        }
    }
}


//Állapotai:
// * NEW, ez az állapota minden újonnan leadott megrendelésnek.
// * CONFIRMED, miután visszaigazolták a rendelést.
// * PREPARED, miután a megrendelést összekészítették.
// * ONBOARD, miután átadták a futárnak.
// * DELIVERED, miután sikeresen kiszállították.
// * RETURNED, sikertelen kiszállítási kísérlet után.
// * DELETED, miután bármilyen okból a rendelést törölték.