package myblog

import com.myblog.AppInitializationService

class BootStrap {

    def init = { servletContext ->
        AppInitializationService.initialize()
    }
    def destroy = {
    }
}
