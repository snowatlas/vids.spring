package vids.spring.service;

import vids.spring.model.Device;

import java.util.List;

public interface DeviceService {
    Device saveDevice(Device device);

    void DeleteDevice(Long id);

    List<Device> findAllDevices();
}
