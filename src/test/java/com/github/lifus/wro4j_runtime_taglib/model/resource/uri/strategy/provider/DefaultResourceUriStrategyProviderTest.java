/*
 * Copyright (c) 2014 Aleksey Polkanov. All rights reserved.
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package com.github.lifus.wro4j_runtime_taglib.model.resource.uri.strategy.provider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.powermock.api.mockito.PowerMockito.mock;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.lifus.wro4j_runtime_taglib.model.group.name.VersionedGroupNameFactory;
import com.github.lifus.wro4j_runtime_taglib.model.resource.uri.root.OptimizedResourcesRootProvider;
import com.github.lifus.wro4j_runtime_taglib.model.resource.uri.strategy.ResourceUriStrategy;
import com.github.lifus.wro4j_runtime_taglib.model.resource.uri.strategy.UnoptimizedResourceUriStrategy;
import com.github.lifus.wro4j_runtime_taglib.model.resource.uri.strategy.VersionedResourceUriStrategy;

/**
 * Test for {@link DefaultResourceUriStrategyProvider}.
 */
public class DefaultResourceUriStrategyProviderTest {

  private DefaultResourceUriStrategyProvider defaultResourceUriStrategyProvider;

  @BeforeMethod
  public void setUp() {
    defaultResourceUriStrategyProvider = new DefaultResourceUriStrategyProvider(mock(OptimizedResourcesRootProvider.class), mock(VersionedGroupNameFactory.class));
  }

  @Test
  public void shouldProvideResourceUriStrategies() {
    assertThat(whenProvideResourceUritrategies(),
        both(
            hasEntry(equalTo(UnoptimizedResourceUriStrategy.ALIAS), instanceOf(UnoptimizedResourceUriStrategy.class)))
        .and(
            hasEntry(equalTo(VersionedResourceUriStrategy.ALIAS), instanceOf(VersionedResourceUriStrategy.class))));
  }

  private Map<String, ResourceUriStrategy> whenProvideResourceUritrategies() {
    return defaultResourceUriStrategyProvider.provideResourceUriStrategies();
  }

}