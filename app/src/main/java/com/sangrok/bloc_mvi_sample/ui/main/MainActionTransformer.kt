package com.sangrok.bloc_mvi_sample.ui.main

import com.sangrok.bloc_mvi_sample.bloc.ActionTransformer
import com.sangrok.bloc_mvi_sample.repository.MockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainActionTransformer(
    private val memberRepository: MockRepository,
) : ActionTransformer<MainAction> {
    override fun transformActions(action: MainAction): Flow<MainAction> {
        return when (action) {
            is MainAction.ToggleAction -> toggleAction(action)
            else -> flow { emit(action) }
        }
    }

    private fun toggleAction(action: MainAction.ToggleAction): Flow<MainAction> = flow {
        emit(MainAction.SetMemberState(action.member.copy(liked = action.member.liked.not())))

        runCatching {
            memberRepository.like(action.member)
        }.onFailure {
            emit(MainAction.SetMemberState(action.member))
        }
    }
}