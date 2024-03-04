package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
        trainerFactory = mock(IPokemonTrainerFactory.class);
    }

    @Test
    public void testCreateTrainer() {
        String name = "Ash";
        Team team = Team.INSTINCT;
        PokemonTrainer expectedTrainer = new PokemonTrainer(name, team, pokedex);
        when(trainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(expectedTrainer);

        PokemonTrainer actualTrainer = trainerFactory.createTrainer(name, team, pokedexFactory);
        assertEquals(expectedTrainer, actualTrainer);
    }
}
