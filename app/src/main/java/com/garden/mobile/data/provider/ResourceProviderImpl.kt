package com.garden.mobile.data.provider

import android.content.Context
import com.garden.mobile.R
import com.garden.mobile.data.utils.DataError
import com.garden.mobile.domian.provider.ResourceProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    @ApplicationContext appContext: Context,
) : ResourceProvider {
    private val resource = appContext.resources

    override fun errorRedLabel(): String =
        resource.getString(R.string.error_red)

    override fun errorTimeoutLabel(): String =
        resource.getString(R.string.error_timeout)

    override fun errorHttpLabel(): String =
        resource.getString(R.string.error_http)

    override fun errorGenericLabel(): String =
        resource.getString(R.string.error_generic)

    override fun parseError(network: DataError.Errors): String =
        when (network) {
            DataError.Errors.RED_ERROR -> errorRedLabel()
            DataError.Errors.TIMEOUT_ERROR -> errorRedLabel()
            DataError.Errors.HTTP_ERROR -> errorRedLabel()
            DataError.Errors.GENERIC_ERROR -> errorRedLabel()
        }

    override fun deletePlantToGardenLabel(): String =
        resource.getString(R.string.delete_plant_to_garden_label)

    override fun addPlantToGardenLabel(): String =
        resource.getString(R.string.add_plant_to_garden_label)
}
