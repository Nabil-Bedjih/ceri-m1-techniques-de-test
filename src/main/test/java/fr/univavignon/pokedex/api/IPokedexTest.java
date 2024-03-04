package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        // Création des mocks pour les dépendances
        pokemonFactory = mock(IPokemonFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);

        // Création du mock pour IPokedex
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void testSize() {
        int expectedSize = 5;
        when(pokedex.size()).thenReturn(expectedSize);

        int actualSize = pokedex.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = mock(Pokemon.class);
        int expectedIndex = 1;
        when(pokedex.addPokemon(pokemon)).thenReturn(expectedIndex);
        int actualIndex = pokedex.addPokemon(pokemon);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        int index = 1;
        Pokemon expectedPokemon = mock(Pokemon.class);
        when(pokedex.getPokemon(index)).thenReturn(expectedPokemon);
        Pokemon actualPokemon = pokedex.getPokemon(index);

        assertEquals(expectedPokemon, actualPokemon);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> expectedPokemons = new ArrayList<>();
        when(pokedex.getPokemons()).thenReturn(expectedPokemons);

        List<Pokemon> actualPokemons = pokedex.getPokemons();
        assertEquals(expectedPokemons, actualPokemons);
    }

    @Test
    public void testGetPokemonsWithComparator() {
        List<Pokemon> expectedPokemons = new ArrayList<>();
        Comparator<Pokemon> comparator = Comparator.comparingInt(Pokemon::getIndex);
        when(pokedex.getPokemons(comparator)).thenReturn(expectedPokemons);

        List<Pokemon> actualPokemons = pokedex.getPokemons(comparator);
        assertEquals(expectedPokemons, actualPokemons);
    }
}
