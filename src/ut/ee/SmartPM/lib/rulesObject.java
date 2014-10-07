package ut.ee.SmartPM.lib;

public class rulesObject<TopLat, TopLon, BottomLat, BottomLon, Name> {
    private TopLat tlat;
    private TopLon tlon;
    private BottomLat blat;
    private BottomLon blon;
    private Name n;
    
    public rulesObject(TopLat tlat, TopLon tlon, BottomLat blat, BottomLon blon, Name n){
        this.tlat = tlat;
        this.tlon = tlon;
        this.blat = blat;
        this.blon = blon;
        this.n = n;
    }
    
    public TopLat getTopLat(){ return tlat; }
    public TopLon getTopLon(){ return tlon; }
    public BottomLat getBottomLat(){ return blat; }
    public BottomLon getBottomLon(){ return blon; }
    public Name getName(){ return n; }
    public void setTopLat(TopLat tlat){ this.tlat = tlat; }
    public void setTopLon(TopLon tlon){ this.tlon = tlon; }
    public void setBottomLat(BottomLat blat){ this.blat = blat; }
    public void setBottomLon(BottomLon blon){ this.blon = blon; }
    public void setName(Name n){ this.n = n; }
}