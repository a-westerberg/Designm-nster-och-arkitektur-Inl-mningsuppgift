package com.skrt.Model.Builder;

import com.skrt.Model.Enum.Color;
import com.skrt.Model.Enum.Material;
import com.skrt.Model.Enum.Size;
import com.skrt.Model.TShirt;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TShirtBuilderTest {

    @Test
    void testTShirtBuilderCreateValidTShirt() {
        TShirt tShirt = new TShirtBuilder()
                .setSize(Size.Medium)
                .setMaterial(Material.Linnen)
                .setColor(Color.Blue)
                .build();

        assertNotNull(tShirt);
        assertEquals(Size.Medium, tShirt.getSize());
        assertEquals(Material.Linnen, tShirt.getMaterial());
        assertEquals(Color.Blue, tShirt.getColor());
        assertEquals("Blue Linnen TShirt", tShirt.getName());
    }

    @Test
    void testTShirtBuilderThrowsExceptionWhenSizeIsNull() {
        TShirtBuilder builder = new TShirtBuilder();
        assertThrows(BuildException.class, () -> builder.setSize(null));
    }

    @Test
    void testTShirtBuilderThrowsExceptionWhenMaterialIsNull() {
        TShirtBuilder builder = new TShirtBuilder();
        assertThrows(BuildException.class, () -> builder.setMaterial(null));
    }

    @Test
    void testTShirtBuilderThrowsExceptionWhenColorIsNull() {
        TShirtBuilder builder = new TShirtBuilder();
        assertThrows(BuildException.class, () -> builder.setColor(null));
    }

    @Test
    void testTShirtBuilderThrowsExceptionWhenBuildCalledWithMissingValues() {
        TShirtBuilder builder = new TShirtBuilder()
                .setSize(Size.Small)
                .setMaterial(Material.Silk);

        assertThrows(BuildException.class, builder::build);
    }

    @Test
    void testBuildThrowsExceptionWhenColorOrMaterialIsMissing(){
        TShirtBuilder builder = new TShirtBuilder();

        Exception exception = assertThrows(BuildException.class, builder::build);
        assertTrue(exception.getMessage().contains("Build process"));
    }

    @Test
    void testBuildThrowsExceptionWhenOnlyColorIsSet(){
        TShirtBuilder builder = new TShirtBuilder()
                .setColor(Color.Blue);

        Exception exception = assertThrows(BuildException.class, builder::build);
        assertTrue(exception.getMessage().contains("Build process"));
    }

    @Test
    void testBuildThrowsExceptionWhenOnlyMaterialIsSet(){
        TShirtBuilder builder = new TShirtBuilder()
                .setMaterial(Material.Linnen);

        Exception exception = assertThrows(BuildException.class, builder::build);
        assertTrue(exception.getMessage().contains("Build process"));
    }
}
