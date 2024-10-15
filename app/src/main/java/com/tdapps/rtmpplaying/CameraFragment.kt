package com.tdapps.rtmpplaying

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import cn.nodemedia.NodePlayer
import com.tdapps.rtmpplaying.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {
    private var _binding: FragmentCameraBinding? = null
    private val binding get() = _binding!!

    private val args: CameraFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startPlaying()
    }

    private fun startPlaying() {
        val url = args.streamUrl.toString()
        val nodePlayer = NodePlayer(requireContext(), "")
        nodePlayer.attachView(binding.playingLayout)
        nodePlayer.start(url)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}