package com.github.izhangzhihao.rainbow.brackets.component

import com.github.izhangzhihao.rainbow.brackets.settings.RainbowSettings
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.extensions.PluginId

class RainbowComponent : ApplicationComponent {
    var updated: Boolean = false

    override fun initComponent() {
        updated = getPlugin()?.version != RainbowSettings.instance.version
        if (updated) {
            RainbowSettings.instance.version = getPlugin()?.version
        }
    }

    companion object {
        val instance: RainbowComponent
            get() = ApplicationManager.getApplication().getComponent(RainbowComponent::class.java)

        private fun getPlugin(): IdeaPluginDescriptor? = PluginManager.getPlugin(PluginId.getId("izhangzhihao.rainbow.brackets"))
    }
}