package barber.gerard.backend.infraestructure.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {
  @Bean
  public CacheManager cacheManager() {
    SimpleCacheManager cacheManager = new SimpleCacheManager();
    cacheManager.setCaches(
      List.of(
          new ConcurrentMapCache("customers"),
          new ConcurrentMapCache("barbers"),
          new ConcurrentMapCache("admins"),
          new ConcurrentMapCache("appointments"),
          new ConcurrentMapCache("cutServices"),
          new ConcurrentMapCache("locations")
      )
    );

    return cacheManager;
  }
}
