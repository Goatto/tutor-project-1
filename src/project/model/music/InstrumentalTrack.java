package project.model.music;

import project.model.item.Author;

import java.util.List;

public class InstrumentalTrack extends MusicTrack
{
    private final List<String> instruments;
    private final boolean isElectronic;

    public InstrumentalTrack(String title, List<Author> authors, int duration, MusicGenre genre,
                             List<String> instruments, boolean isElectronic)
    {
        super(title, authors, duration, genre);
        this.instruments = instruments;
        this.isElectronic = isElectronic;
    }

    public List<String> getInstruments()
    {
        return this.instruments;
    }

    public boolean getIsElectronic()
    {
        return this.isElectronic;
    }
}
