package dev.opuspepper.AdventOfCodeDay10.objects;

import java.util.Objects;

public class pixel {
    Integer pixelPosition = 0;

    public pixel(Integer pixelPosition) {
        this.pixelPosition = pixelPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pixel pixel = (pixel) o;
        return pixelPosition.equals(pixel.pixelPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pixelPosition);
    }
}
