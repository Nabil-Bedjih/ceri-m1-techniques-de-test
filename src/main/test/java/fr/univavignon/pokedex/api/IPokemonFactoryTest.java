package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        int index = 1;
        int cp = 100;
        int hp = 50;
        int dust = 10;
        int candy = 5;

        Pokemon expectedPokemon = new Pokemon(index, "Bulbasaur", 100, 100, 100, cp, hp, dust, candy, 0.8);
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedPokemon);
        Pokemon actualPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        assertEquals(expectedPokemon, actualPokemon);
    }
}
