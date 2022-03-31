package lectures.l7;

public class Sport {

    private String name;
    public int durationInMinutes;
    public boolean playedInTurkeyProfessionally;
    public boolean isTeamSport;
    private SportType type;
    public boolean isPlayedOutside;
    public boolean isRisky;

    //constructor
    public Sport() {

    }
    public Sport(String _name, int i, boolean b, SportType wrb, boolean ccc) {
        this.name = _name;
        this.durationInMinutes = i;
        // this keyword might be optional depending on the existence of the same name variable
        this.playedInTurkeyProfessionally = b;
        this.isTeamSport = ccc;
        this.type = wrb;
        this.checkRisk();
    }
    public Sport(String _name, int i, boolean b, SportType wrb, boolean ccc, boolean _isPlayedOutside) {
        this.name = _name;
        this.durationInMinutes = i;
        // this keyword might be optional depending on the existence of the same name variable
        this.playedInTurkeyProfessionally = b;
        this.isTeamSport = ccc;
        this.type = wrb;
        this.isPlayedOutside=_isPlayedOutside;
        this.checkRisk();
    }
    private void checkRisk() {
        // if some sport is longer than 60 minutes and is not a team sport, it is risky
        if(this.durationInMinutes>60 && !this.isTeamSport)
        {
            this.isRisky=true;
        }
    }
    public String getName() {
        return this.name;
    }
    public void setName(String s) {
        this.name=s;
    }

}
