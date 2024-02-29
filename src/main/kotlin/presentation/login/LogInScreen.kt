package presentation.login

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import common.LocalResources
import common.string.LocalStrings
import presentation.common.AppFilledButton
import presentation.common.AppTextField
import presentation.common.ObserveEffect
import presentation.selectproject.SelectProjectScreen
import presentation.login.LogInEffect.NavigateToSelectProject
import presentation.login.LogInNonUiAction.SigIn
import presentation.login.LogInUiAction.ToggleTokenVisibility
import presentation.login.LogInNonUiAction.UpdateAddressTextInput
import presentation.login.LogInNonUiAction.UpdateTokenTextInput

class LogInScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<LogInScreenModel>()

        var isTokenVisible by rememberSaveable { mutableStateOf(false) }
        val screenState by screenModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        screenModel.ObserveEffect { effect ->
            when (effect) {
                NavigateToSelectProject -> {
                    navigator.push(SelectProjectScreen())
                }
            }

        }

        screenContent(screenState, isTokenVisible) { action ->
            if (action is LogInUiAction) {
                when (action) {
                    ToggleTokenVisibility -> {
                        isTokenVisible = !isTokenVisible
                    }
                }
            } else if (action is LogInNonUiAction) {
                screenModel.sendAction(action)
            }
        }
    }

    @Composable
    private fun screenContent(
        screenState: LogInScreenState,
        isTokenVisible: Boolean,
        actioner: (LogInAction) -> Unit
    ) {
        val resources = LocalResources.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                Modifier
                    .align(Alignment.Center)
                    .verticalScroll(rememberScrollState())
                    .padding(all = 56.dp)
                    .width(IntrinsicSize.Max)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerLowest,
                        shape = MaterialTheme.shapes.large
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        shape = MaterialTheme.shapes.large
                    )
                    .padding(32.dp)
            ) {
                LoginForm(
                    modifier = Modifier.weight(1f),
                    screenState = screenState,
                    actioner = actioner,
                    isTokenVisible = isTokenVisible
                )

                Image(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically),
                    painter = painterResource(resources.loginIllustration),
                    contentDescription = "login illustration",
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }

    @Composable
    private fun LoginForm(
        screenState: LogInScreenState,
        isTokenVisible: Boolean,
        modifier: Modifier = Modifier,
        actioner: (LogInAction) -> Unit
    ) {
        val strings = LocalStrings.current
        val resources = LocalResources.current

        Column(
            modifier = modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .width(IntrinsicSize.Max)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(96.dp),
                painter = painterResource(resources.logo),
                contentDescription = "logo",
            )

            Spacer(Modifier.size(48.dp))

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = strings.welcomeToGitFast,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Spacer(modifier = Modifier.size(80.dp))

            Text(
                text = strings.enterYourGitlabAddress,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Spacer(modifier = Modifier.size(8.dp))

            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = screenState.address,
                isError = screenState.addressFieldHasError == true,
                trailingIcon = {
                    Icon(
                        painter = painterResource(resources.world),
                        contentDescription = "ic world",
                    )
                },
                onValueChange = {
                    actioner(UpdateAddressTextInput(it))
                },
            )
            AnimatedVisibility(
                modifier = Modifier.padding(4.dp),
                visible = screenState.addressFieldHasError == true
            ) {
                Text(
                    text = strings.correctYourAddress,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelMedium,
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = strings.enterYourToken,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Spacer(modifier = Modifier.size(8.dp))

            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = screenState.token,
                isError = screenState.tokenFieldHasError == true,
                onValueChange = {
                    actioner(UpdateTokenTextInput(it))
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            actioner(ToggleTokenVisibility)
                        }
                    ) {
                        AnimatedContent(isTokenVisible) { isVisible ->
                            Icon(
                                painter = painterResource(
                                    if (isVisible) {
                                        resources.visibilityOn
                                    } else {
                                        resources.visibilityOff
                                    }
                                ),
                                contentDescription = if (isVisible) {
                                    "visible token"
                                } else {
                                    "invisible token"
                                }
                            )
                        }
                    }
                },
                visualTransformation = if (isTokenVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            )
            AnimatedVisibility(
                modifier = Modifier.padding(4.dp),
                visible = screenState.tokenFieldHasError == true
            ) {
                Text(
                    text = strings.enterTokenCorrectly,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelMedium,
                )
            }

            Spacer(modifier = Modifier.size(4.dp))

            TextButton(
                onClick = {

                }
            ) {
                Text(
                    text = strings.howToCreateToken,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            Spacer(modifier = Modifier.size(48.dp))

            AppFilledButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { actioner(SigIn) }
            ) {
                Text(
                    text = strings.signIn,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
