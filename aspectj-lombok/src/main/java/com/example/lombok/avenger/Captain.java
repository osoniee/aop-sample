package com.example.lombok.avenger;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Captain {
    private final String motto;
    public void fly() throws NoSuchMethodException {
        throw new NoSuchMethodException("Captain Rogers cannot fly...");
    }

    public String assemble() {
        log.info("avengers, assemble");
        return this.getMotto();
    }
}