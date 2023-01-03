package com.example.common.dispatcher

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class InjectionDispatcher(val dispatchers: PodexDispatchers)

enum class PodexDispatchers {
    IO
}
