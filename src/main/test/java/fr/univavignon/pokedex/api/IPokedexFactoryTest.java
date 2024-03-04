package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokedex() throws PokedexException {
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
        IPokedex actualPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(pokedex, actualPokedex);
    }
}
