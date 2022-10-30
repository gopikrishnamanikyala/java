package gt.api.email;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface EmailService {
    @PostMapping("/sendEmail")
    ResponseEntity<Void> sendEmailWithAttachments(@RequestBody @Valid @NotNull EmailDto email);
}
