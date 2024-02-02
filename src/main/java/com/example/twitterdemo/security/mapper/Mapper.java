package com.example.twitterdemo.security.mapper;

public interface Mapper<D, S>{
    D map(S source);
}
