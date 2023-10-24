import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'openappnapp_method_channel.dart';

abstract class OpenappnappPlatform extends PlatformInterface {
  /// Constructs a OpenappnappPlatform.
  OpenappnappPlatform() : super(token: _token);

  static final Object _token = Object();

  static OpenappnappPlatform _instance = MethodChannelOpenappnapp();

  /// The default instance of [OpenappnappPlatform] to use.
  ///
  /// Defaults to [MethodChannelOpenappnapp].
  static OpenappnappPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [OpenappnappPlatform] when
  /// they register themselves.
  static set instance(OpenappnappPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
