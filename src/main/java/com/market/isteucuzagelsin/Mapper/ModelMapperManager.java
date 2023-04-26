package com.market.isteucuzagelsin.Mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperManager implements ModelMapperService{
    private ModelMapper mapper;

    public ModelMapperManager(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ModelMapper forResponse() {
        // TODO Auto-generated method stub
        this.mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.mapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.mapper;
        // TODO Auto-generated method stub

    }
}
