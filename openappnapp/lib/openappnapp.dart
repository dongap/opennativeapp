
import 'openappnapp_platform_interface.dart';

class Openappnapp {
  Future<String?> getPlatformVersion() {
    return OpenappnappPlatform.instance.getPlatformVersion();
  }
}
