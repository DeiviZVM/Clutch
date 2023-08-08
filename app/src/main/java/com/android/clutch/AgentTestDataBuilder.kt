package com.android.clutch

import com.android.clutch.domain.model.AgentModel

class AgentTestDataBuilder {
    val id = 1
    var name = "Killjoy"
    var portraitUrl = "https://cdn.pandascore.co/images/valorant/agent/image/252/killjoy_icon-png-png-png-png-png-png-png-png"

    fun withName(name: String): AgentTestDataBuilder {
        this.name = name
        return this
    }

    fun withPortraitUrl(portraitUrl: String): AgentTestDataBuilder {
        this.portraitUrl = portraitUrl
        return this
    }

    fun buildSingle() = AgentModel(
        id = id,
        name = name,
        portraitUrl = portraitUrl
    )
}