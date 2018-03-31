package com.playgrounds.resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "${api.path}")
@Transactional
public class RegionRest {
}
