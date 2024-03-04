package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        int index = 1;
        PokemonMetadata expectedMetadata = new PokemonMetadata(1,"Bulbasaur", 126, 126, 90);

        when(metadataProvider.getPokemonMetadata(index)).thenReturn(expectedMetadata);

        PokemonMetadata actualMetadata = metadataProvider.getPokemonMetadata(index);
        assertEquals(expectedMetadata, actualMetadata);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        int invalidIndex = -1;
        when(metadataProvider.getPokemonMetadata(invalidIndex)).thenThrow(new PokedexException("Invalid index"));
        metadataProvider.getPokemonMetadata(invalidIndex);
    }
}
