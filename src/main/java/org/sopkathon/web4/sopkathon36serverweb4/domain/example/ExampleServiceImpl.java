package org.sopkathon.web4.sopkathon36serverweb4.domain.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService{

  private final ExampleRepository exampleRepository;
}
