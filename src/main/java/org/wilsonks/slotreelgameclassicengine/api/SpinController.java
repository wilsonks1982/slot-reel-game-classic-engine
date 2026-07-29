package org.wilsonks.slotreelgameclassicengine.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wilsonks.slotreelgameclassicengine.config.GameConfigProperties;
import org.wilsonks.slotreelgameclassicengine.config.PayTableProperties;

@RestController
@RequestMapping("/api/reels/classic")
@RequiredArgsConstructor
public class SpinController {
    private final SpinService spinService;

    @GetMapping("/paytable")
    public ResponseEntity<PayTableProperties> getPaylines() {
        return ResponseEntity.ok(spinService.getPaylines());
    }

    @GetMapping("/gameconfig")
    public ResponseEntity<GameConfigProperties> getPaytable() {
        return ResponseEntity.ok(spinService.getGameConfig());
    }

    @PostMapping("/spin")
    public ResponseEntity<SpinResponse> spin(@RequestBody @Valid SpinRequest request) {
        SpinResponse response = spinService.spin(request);
        return ResponseEntity.ok(response);
    }
}
