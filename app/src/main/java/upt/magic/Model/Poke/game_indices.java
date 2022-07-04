package upt.magic.Model.Poke;

public class game_indices {
    private int game_index;
    private version version;

    public game_indices() {
    }

    public game_indices(int game_index, upt.magic.Model.Poke.version version) {
        this.game_index = game_index;
        this.version = version;
    }

    public int getGame_index() {
        return game_index;
    }

    public void setGame_index(int game_index) {
        this.game_index = game_index;
    }

    public upt.magic.Model.Poke.version getVersion() {
        return version;
    }

    public void setVersion(upt.magic.Model.Poke.version version) {
        this.version = version;
    }
}
