package upt.magic.Model.Poke;

import java.util.ArrayList;

public class Pokemon {
    private ArrayList<abilities> abilities = new ArrayList<abilities>();
    private float base_experience;
    private ArrayList<game_indices> game_indices = new ArrayList<game_indices>();
    private float height;
    private int id;
    private String name;
    private species species;

    public Pokemon() {
    }

    public Pokemon(ArrayList<upt.magic.Model.Poke.abilities> abilities, float base_experience, ArrayList<upt.magic.Model.Poke.game_indices> game_indices, float height, int id, String name, upt.magic.Model.Poke.species species) {
        this.abilities = abilities;
        this.base_experience = base_experience;
        this.game_indices = game_indices;
        this.height = height;
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public ArrayList<upt.magic.Model.Poke.abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<upt.magic.Model.Poke.abilities> abilities) {
        this.abilities = abilities;
    }

    public float getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(float base_experience) {
        this.base_experience = base_experience;
    }

    public ArrayList<upt.magic.Model.Poke.game_indices> getGame_indices() {
        return game_indices;
    }

    public void setGame_indices(ArrayList<upt.magic.Model.Poke.game_indices> game_indices) {
        this.game_indices = game_indices;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public upt.magic.Model.Poke.species getSpecies() {
        return species;
    }

    public void setSpecies(upt.magic.Model.Poke.species species) {
        this.species = species;
    }
}
