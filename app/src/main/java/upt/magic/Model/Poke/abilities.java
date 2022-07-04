package upt.magic.Model.Poke;

public class abilities {
    private ability ability;
    private Boolean  is_hidden;
    private float slot;

    public abilities() {
    }

    public abilities(upt.magic.Model.Poke.ability ability, Boolean is_hidden, float slot) {
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }

    public upt.magic.Model.Poke.ability getAbility() {
        return ability;
    }

    public void setAbility(upt.magic.Model.Poke.ability ability) {
        this.ability = ability;
    }

    public Boolean getIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(Boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public float getSlot() {
        return slot;
    }

    public void setSlot(float slot) {
        this.slot = slot;
    }
}
