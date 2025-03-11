package lk.ijse.megacitycab.service.impl;

import lk.ijse.megacitycab.dto.BoockingDTO;
import lk.ijse.megacitycab.repostory.BoockingRepostory;
import lk.ijse.megacitycab.repostory.impl.BoockingRepostoryImpl;
import lk.ijse.megacitycab.service.BoockingService;
import lk.ijse.megacitycab.util.map.Map;

import java.io.IOException;
import java.util.List;

public class BoockingServiceImpl implements BoockingService {

    private BoockingRepostory boockingRepostory = new BoockingRepostoryImpl();
    private Map map = new Map();
    @Override
    public void saveBoocking(BoockingDTO boocking) throws IOException {
        boockingRepostory.saveBoocking(map.toBoocking(boocking));
    }

    @Override
    public List<BoockingDTO> getAllBoocking() throws IOException {
        return map.toBoockingDtoList(boockingRepostory.getAllBoocking());
    }

    @Override
    public void updateBoocking(BoockingDTO boocking) throws IOException {
        boockingRepostory.updateBoocking(map.toBoocking(boocking));
    }


}
