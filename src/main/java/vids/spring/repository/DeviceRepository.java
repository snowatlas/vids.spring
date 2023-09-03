package vids.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vids.spring.model.Device;



public interface DeviceRepository extends JpaRepository<Device,Long> {

}
